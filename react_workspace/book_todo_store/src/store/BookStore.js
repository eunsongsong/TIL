import { observable, computed, action } from 'mobx';
import Books from '../Books';
class BookStore {

    @observable books = Books;
    @observable book = Books[0];

    @computed get _book() {
        return this.book ? { ...this.book } : {};
    }

    @computed get _books() {
        return this.books ? this.books.slice() : [];
    }

    @action select = (book) => {
        this.book = book;
    }
}

export default new BookStore();