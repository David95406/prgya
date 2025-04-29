export default class Karakter {
    #nev;
    #faj;
    #leiras;
    #szint;

    constructor(nev, faj, leiras, szint) {
        this.setNev(nev);
        this.setFaj(faj);
        this.setLeiras(leiras);
        this.setSzint(szint);

        this.getNev = this.getNev.bind(this);
        this.getFaj = this.getFaj.bind(this);
        this.getLeiras = this.getLeiras.bind(this);
        this.getSzint = this.getSzint.bind(this);
    }

    setNev(nev) {
        this.#nev = nev;
    }

    setFaj(faj) {
        this.#faj = faj;
    }

    setLeiras(leiras) {
        this.#leiras = leiras;
    }

    setSzint(szint) {
        this.#szint = szint;
    }

    getNev() {
        return this.#nev;
    }

    getFaj() {
        return this.#faj;
    }

    getLeiras() {
        return this.#leiras;
    }

    getSzint() {
        return this.#szint;
    }

}