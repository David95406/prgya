export default class FavoriteData {
    #title
    #author
    #image

    constructor(title, author, image) {
        this.setTitle(title)
        this.setAuthor(author)
        this.setImage(image)

        this.getTitle = this.getTitle.bind(this)
        this.getAuthor = this.getAuthor.bind(this)
        this.getImage = this.getImage.bind(this)
    }

    setTitle(title) {
        this.#title = title
    }

    getTitle() {
        return this.#title
    }

    setAuthor(author) {
        this.#author = author
    }

    getAuthor() {
        return this.#author
    }

    setImage(image) {
        this.#image = image
    }

    getImage() {
        return this.#image
    }

}