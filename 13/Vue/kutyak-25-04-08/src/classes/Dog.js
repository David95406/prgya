export default class Dog{
    #id;
    #url;
    #isFavorite;
    #likes;

    constructor(url, isFavorite, likes){
        this.setUrl(url);
        this.setIsFavorite(isFavorite);
        this.setLikes(likes);

        this.getUrl = this.getUrl.bind(this);
        this.getIsFavorite = this.getIsFavorite.bind(this);
        this.getLikes = this.getLikes.bind(this);
        this.getCrudID = this.getCrudID.bind(this);
        this.setCrudID = this.setCrudID.bind(this);
        this.setLikes = this.setLikes.bind(this);
    }

    setUrl(url){
        this.#url = url;
    }

    setIsFavorite(isFavorite){
        this.#isFavorite = isFavorite;
    }

    setCrudID(id){
        this.#id = id;
    }

    getCrudID(){
        return this.#id;
    }

    setLikes(likes){
        this.#likes = likes;
    }

    getUrl(){
        return this.#url;
    }

    getIsFavorite(){
        return this.#isFavorite;
    }

    getLikes(){
        return this.#likes;
    }
}
