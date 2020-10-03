import axios from "axios";
// import request from "./cors";

class BookApi {
  //   URL = "http://localhost:9000/api/books/";
  URL = "/api/books/";

  bookList() {
    axios
      .get(this.URL)
      .then((response) => {
        return response.data;
      })
      .catch((error) => console.log(error));
  }

  // bookDetail(ISBN) : URL/ISBN Get Book
  bookDetail(ISBN) {
    axios
      .get(this.URL + `${ISBN}/`)
      .then((response) => {
        return response.data;
      })
      .catch((error) => console.log(error));
  }

  // bookCreate(BookApiModel) : URL POST
  bookCreate(bookApiModel) {
    let bookJson = JSON.stringify(bookApiModel);
    return axios
      .post(this.URL, bookApiModel)
      .then((response) => (response && response.data) || null);

    // return axios
    //   .post(this.URL, bookApiModel)
    //   .then((response) => (response && response.data) || null);

    // response != null && response.data != null ? response.data : null
  }

  // bookModify(BookApiModel) : URL PUT
  bookModify(bookApiModel) {
    return axios
      .put(this.URL, bookApiModel)
      .then((response) => (response && response.data) || null);
  }

  // bookDelete(ISBN) : URL/ISBN Delete
  bookDelete(ISBN) {
    return axios
      .delete(this.URL + `${ISBN}/`)
      .then((response) => (response && response.data) || null);
  }

  // search(searchType, keyword) : URL/searchType/keyword Get : Book[]
  search(searchType, keyword) {
    return axios
      .get(this.URL + `${searchType}/${keyword}/`)
      .then((response) => (response && response.data) || null);
  }
}

export default BookApi;
