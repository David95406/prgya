export default class Screening {
    #movieId;
    #roomId;
    #time;
    #seets;

    constructor(movieId, roomId, time, seets) {
        this.setMovieId(movieId);
        this.setRoomId(roomId);
        this.setTime(time);
        this.setSeets(seets);

        this.getMovieId = this.getMovieId.bind(this);
        this.getRoomId = this.getRoomId.bind(this);
        this.getTime = this.getTime.bind(this);
        this.getSeets = this.getSeets.bind(this);
        this.isFree = this.isFree.bind(this);
        this.setSeet = this.setSeet.bind(this);
        this.setSeets = this.setSeets.bind(this);
    }

    setMovieId(movieId) {
        this.#movieId = movieId;
    }

    setRoomId(roomId) {
        this.#roomId = roomId;
    }

    setTime(time) {
        this.#time = time;
    }

    setSeets(seets) {
        this.#seets = seets;
    }

    getMovieId() {
        return this.#movieId;
    }

    getRoomId() {
        return this.#roomId;
    }

    getTime() {
        return this.#time;
    }

    getSeets() {
        return this.#seets;
    }

    isFree(row, column) {
        return this.#seets[row][column];
    }

    setSeet(row, column) {
        this.#seets[row][column] = true;
    }

}