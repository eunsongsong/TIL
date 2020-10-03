import { observable, computed, action } from "mobx";
import BookApi from "../api/BookApi";

class BookStore {
  bookApi = new BookApi();

  @observable books = []; // BookApi - findAll()
  @observable book = null; // BookApi = (ISBN)
  @observable errorMessage = "";

  @computed get _book() {
    return this.book ? { ...this.book } : {};
  }

  @computed get _books() {
    return this.books ? this.books.slice() : [];
  }

  @computed get getErrorMessage() {
    return this.errorMessage ? this.errorMessage : "FAIL.";
  }

  @action select = (book) => {
    // this.book = book;
    this.findByBook(book.ISBN);
  };

  @action
  async bookList() {
    this.books = await this.bookApi.bookList();
  }

  @action
  async findByBook(ISBN) {
    this.book = await this.bookApi.bookDetail(ISBN);
  }

  @action
  async bookCreate(bookApiModel) {
    const result = this.bookApi.bookCreate(bookApiModel);
    if (result == null) this.errorMessage = "CREATE ERROR!";
  }

  @action
  async bookDelete(ISBN) {
    const result = this.bookApi.bookDelete(ISBN);
    if (result == null) this.errorMessage = `${ISBN} DELETE ERROR!`;
  }

  @action
  async bookUpdate(bookApiModel) {
    const result = this.bookApi.bookUpdate(bookApiModel);
    if (result == null)
      this.errorMessage = `${bookApiModel.ISBN} UPDATE ERROR!`;
  }

  @action
  async search(searchType, keyword) {
    this.books = this.bookApi.search(searchType, keyword);
  }
}

export default new BookStore();