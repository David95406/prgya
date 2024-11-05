export default class Track {
    #title
    #artist
    #file

    constructor(title, artist, file) {
        this.#title = title
        //this.setTitle(title)
        this.setTitle = this.setTitle.bind(this)
        this.getTitle = this.getTitle.bind(this)

        this.#artist = artist
        //this.setArtist(artist)
        this.setArtist = this.setArtist.bind(this)
        this.getArtist = this.getArtist.bind(this)

        this.#file = file
        //this.setFile(file)
        this.setFile = this.setFile.bind(this)
        this.getFile = this.getFile.bind(this)


    }

    setTitle(title) {
        this.#title = title
    }

    getTitle() {
        return this.#title
    }

    setArtist(artist) {
        this.#artist = artist
    }

    getArtist() {
        return this.#artist
    }

    setFile(file) {
        this.#file = file
    }

    getFile() {
        return this.#file
    }
}