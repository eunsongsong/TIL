import axios from "axios";

class TodoApi {
  URL = "/api/todos/"; //http://localhost:9001/api/todos

  //todoCreate(todoApiModel) : URL POST
  todoCreate(todo) {
    // let todoJson = todo;
    console.log("TodoAPI ==> " + todo);
    return axios
      .post(this.URL, todo)
      .then((response) => (response && response.data) || null);
  }

  //todoDetail(todoNum) : URL GET : Todo
  todoDetail(todoNum) {
    return axios
      .get(this.URL + `${todoNum}/`)
      .then((response) => (response && response.date) || null);
  }

  //todoList() : URL GET : [Todo]
  todoList() {
    return axios
      .get(this.URL)
      .then((response) => (response && response.data) || null);
  }

  //todoModify(todoApiModel) : URL PUT
  todoModify(todoApiModel) {
    let todoJson = JSON.stringify(todoApiModel);
    return axios
      .put(this.URL, todoJson)
      .then((response) => (response && response.data) || null);
  }

  //todoDelete() : URL DELETE
  todoDelete(todoNum) {
    return axios
      .delete(this.URL + `${todoNum}/`)
      .then((response) => (response && response.data) || null);
  }
}

export default TodoApi;
