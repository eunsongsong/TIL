import React, { Component } from "react";
import { observer, inject } from "mobx-react";
import TodoListView from "../view/TodoListView";

@inject("todoStore")
@observer
class TodoListContainer extends Component {
  componentDidMount() {
    // console.log("todolistContainer: ");
    const { todoStore } = this.props;
    if (todoStore) {
      todoStore.selectAll();
    }
  }

  onSelectTodo = (todoNum) => {
    this.props.todoStore.selectTodo(todoNum);
  };

  render() {
    const todos = this.props.todoStore;
    console.log("render");
    console.log("+++",todos);
    return <TodoListView todos={todos.getTodos} onSelectTodo={this.onSelectTodo} />;
  }
}

export default TodoListContainer;
