<script setup>

</script>

<template>
    <aside>
        <h2>Cart</h2>
        <div class="cartProduct">
            <h3>Lorem ipsum</h3>
            <div class="d-flex">
                <div class="price">$ 20</div>
                <div class="quantity">Quantity: 1</div>
            </div>
        </div>
        <div class="total">Total quantity: 1</div>
        <div class="mb-3">
            <button class="btn w-100">Checkout ($ 200)</button>
        </div>
    </aside>
</template>

<style scoped>
aside {
    margin-top: 30px;
}

h3 {
    font-size: 18px;
}

.d-flex {
    justify-content: space-between;
    margin-bottom: 10px;
    padding-bottom: 15px;
    border-bottom: 1px solid #ccc;
}

.price {
    color: #3AB982;
    font-weight: 700;
}

.btn {
    margin-top: 15px;
}
</style>