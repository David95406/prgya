export class Book {
    #title
    #author
    #desc
    
    constructor(title, author, desc) {
        this.setTitle(title)
        this.setAuthor(author)
        this.setDesc(desc)

        this.getTitle = this.getTitle.bind(this)
        this.getAuthor = this.getAuthor.bind(this)
        this.getDesc = this.getDesc.bind(this)

        this.setTitle = this.setTitle.bind(this)
        this.setAuthor = this.setAuthor.bind(this)
        this.setDesc = this.setDesc.bind(this)
    }

    setTitle(title) {
        this.#title = title
    }

    setAuthor(author) {
        this.#author = author
    }

    setDesc(desc) {
        this.#desc = desc
    }

    getTitle() {
        return this.#title
    }

    getAuthor() {
        return this.#author
    }

    getDesc() {
        return this.#desc
    }


}