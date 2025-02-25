<script setup>
import axios from 'axios';
import { CRUD_API, CRUD_API_RANDOM_USER } from './secret/secret';
import { ref } from 'vue';

const uploadRandomUser = (async (ru_name, ru_email, ru_country, ru_city, ru_postcode, ru_street, ru_phone, ru_picture, ru_username, ru_password, ru_salt, ru_sha1) => {
  await axios.post(CRUD_API_RANDOM_USER, {
    name: ru_name,
    email: ru_email,
    country: ru_country,
    city: ru_city,
    postcode: ru_postcode,
    street: ru_street,
    phone: ru_phone,
    picture: ru_picture,
    username: ru_username,
    password: ru_password,
    salt: ru_salt,
    sha1: ru_sha1
  })
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.error("error:" + error)
    })
    .finally(() => {
      console.log("sikeres feltoltes")
    })

})

const getRandomUser = (async (n) => {
  for (let i = 0; i < n; i++) {
    await axios.get("https://randomuser.me/api/")
      .then((response) => {
        var ru_name = response.data["results"][0]["name"]["title"] + " " + response.data["results"][0]["name"]["first"] + " " + response.data["results"][0]["name"]["last"]
        var ru_email = response.data["results"][0]["email"]
        var ru_country = response.data["results"][0]["location"]["country"]
        var ru_city = response.data["results"][0]["location"]["city"]
        var ru_postcode = response.data["results"][0]["location"]["postcode"]
        var ru_street = response.data["results"][0]["location"]["street"]["number"] + ": " + response.data["results"][0]["location"]["street"]["name"]
        var ru_phone = response.data["results"][0]["phone"]
        var ru_picture = response.data["results"][0]["picture"]["medium"]
        var ru_username = response.data["results"][0]["login"]["username"]
        var ru_password = response.data["results"][0]["login"]["password"]
        var ru_salt = response.data["results"][0]["login"]["salt"]
        var ru_sha1 = response.data["results"][0]["login"]["sha1"]

        uploadRandomUser(ru_name, ru_email, ru_country, ru_city, ru_postcode, ru_street, ru_phone, ru_picture, ru_username, ru_password, ru_salt, ru_sha1)
        /*
        console.log("Name: " + ru_name);
        console.log("Email: " + ru_email);
        console.log("Country: " + ru_country);
        console.log("City: " + ru_city);
        console.log("Postcode: " + ru_postcode);
        console.log("Street: " + ru_street);
        console.log("Phone: " + ru_phone);
        console.log("Picture: " + ru_picture);
        console.log("Username: " + ru_username);
        console.log("Password: " + ru_password);
        console.log("Salt: " + ru_salt);
        console.log("SHA1: " + ru_sha1);
        */

      })
      .catch((error) => {
        console.error("error:" + error)
      })
      .finally(() => {
        console.log("sikeres lekeres")
      })
  }
})
//getRandomUser(100)

const rusers = ref([])

const getUsers = (async () => {
  await axios.get(CRUD_API_RANDOM_USER)
    .then((response) => {
      rusers.value = response.data
    })
    .catch((error) => {
      console.error("error: " + error)
    })
    .finally(() => {
      console.log("sikeres lekeres a reeldev.hu-rol")
    })
})
getUsers()

const removeUser = (async (ru_id) => {
  if (confirm("Are you sure?")) {
    axios.delete((CRUD_API_RANDOM_USER + "/" + ru_id))
      .then((response) => {
        console.log(response.data.message)
      })
      .catch((error) => {
        console.error("error: " + error)
      })
      .finally(() => {
        alert("sikeres torles!")
      })
  }
})

const editedUser = ref()
const nameInput = ref("")
const phoneInput = ref("")
const emailInput = ref("")
const editUser = ((user) => {
  nameInput.value = user.name
  phoneInput.value = user.phone
  emailInput.value = user.email
  editedUser.value = user
})

const saveUser = (async () => {
  editedUser.value.name = nameInput.value
  editedUser.value.phone = phoneInput.value
  editedUser.value.email = emailInput.value

  await axios.put((CRUD_API_RANDOM_USER + "/" + editedUser.value.id), {
    name: editedUser.value.name,
    email: editedUser.value.email,
    country: editedUser.value.country,
    city: editedUser.value.city,
    postcode: editedUser.value.postcode,
    street: editedUser.value.street,
    phone: editedUser.value.phone,
    picture: editedUser.value.picture,
    username: editedUser.value.username,
    password: editedUser.value.password,
    salt: editedUser.value.salt,
    sha1: editedUser.value.sha1
  })
    .then((response) => {
      console.log(response.data)
    })
    .catch((error) => {
      console.error("error:" + error)
    })
    .finally(() => {
      alert("sikeres update")
    })
})
</script>

<template>
  <header>
    <h1 class="text-center p-5">Random Users</h1>
  </header>
  <main>
    <section class="container">
      <table class="table table-dark">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">E-mail</th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(user, index) in rusers">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ user.name }}</td>
            <td>{{ user.email }}</td>
            <td>{{ user.phone }}</td>
            <td>{{ user.country }} {{ user.postcode }} {{ user.city }}, {{ user.street }}</td>
            <td>
              <span class="p-3" data-bs-toggle="modal" data-bs-target="#editModal" @click="editUser(user)">Edit</span>
              <span @click="removeUser(user.id)" class="p-3">Delete</span>
            </td>
          </tr>
        </tbody>
      </table>
    </section>
    <section>
      <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="editModalLabel">Edit user</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <div class="mb-3">
                <label for="exampleInputName" class="form-label">Name</label>
                <input v-model="nameInput" type="text" class="form-control" id="exampleInputName">
              </div>
              <div class="mb-3">
                <label for="exampleInputPhone" class="form-label">Phone</label>
                <input v-model="phoneInput" type="text" class="form-control" id="exampleInputPhone">
              </div>
              <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input v-model="emailInput" type="email" class="form-control" id="exampleInputEmail1"
                  aria-describedby="emailHelp">
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button @click="saveUser" type="button" class="btn btn-primary" data-bs-dismiss="modal">Save
                changes</button>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <footer>
    <p>&copy; All rights reserved.</p>
  </footer>
</template>

<style scoped>
footer {
  padding: 1rem;
  text-align: center;
  border-top: 1px solid #e9ecef;
  width: 100%;
  bottom: 0;
}

footer p {
  margin: 0;
  color: #6c757d;
}
</style>