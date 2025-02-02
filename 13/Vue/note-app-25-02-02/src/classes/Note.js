export default class Note {
    #text
    #time

    constructor(text) {
        this.setText(text)
        this.setTime()
        
        this.getText = this.getText.bind(this)
        this.getTime = this.getTime.bind(this)
    }

    setText(text) {
        this.#text = text
    }

    getText() {
        return this.#text
    }

    setTime(time) {
        this.#time = new Date()
    }

    getTime() {
        const options = { 
            year: 'numeric', 
            month: '2-digit', 
            day: '2-digit', 
            hour: '2-digit', 
            minute: '2-digit', 
            second: '2-digit', 
            hour12: true 
        };
        return this.#time.toLocaleString('en-US', options);
    }

}