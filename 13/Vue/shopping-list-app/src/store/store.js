import {defineStore} from "pinia";

export const useShoppingListStore = defineStore('shoppingList', {
    state: (() => ({
        items: [],
        newItem: '',
        newQuantity: 1,
    })),
    actions: {
        addItem() {
            if(this.newItem.trim() != '') {
                this.items.push({
                    name: this.newItem,
                    quantity: this.newQuantity,
                })
            }
        },
        removeItem(index) {
            this.items.splice(index, 1)
        }
    }
})