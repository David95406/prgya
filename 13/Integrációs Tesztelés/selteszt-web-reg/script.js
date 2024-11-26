const form = document.getElementById("registrationForm");
const result = document.getElementById("result");

form.addEventListener("submit", function(event) {
  event.preventDefault();
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();

  if (name && email && password) {
    result.textContent = "Sikeres regisztráció!";
    result.style.color = "green";
  } else {
    result.textContent = "Minden mezőt ki kell tölteni!";
    result.style.color = "red";
  }
});
