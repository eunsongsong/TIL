import React, { Component } from 'react';
import TodoEditFormView from './component/TodoEditFormView';
import TodoListView from './component/TodoListView';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todos: [],
      todo: [
        {
          id: 1,
          title: '리엑트의 기초 알기',
          checked: true,
          date: '2020-08-10 16:00',
        },
        {
          id: 2,
          title: '컴포넌트 스타일링 하기',
          checked: true,
          date: '2020-08-10 18:45',
        },
        {
          id: 3,
          title: '일정 관리 앱 만들기',
          checked: false,
          date: '2020-08-10 19:15',
        },
      ],
      inputText: '',
      nextId: 4,
      modify: true,
      date2: '',
    };
  }

  onAddTodo = () => {
    const { todo, nextId, inputText, date2 } = this.state;
    this.setState({
      todo: todo.concat({
        id: nextId,
        title: inputText,
        checked: false,
        date: date2
      }),
      // inputText: '',
      nextId: nextId + 1,
    });
  };

  onSetTodoProp = (e, date) => {
    this.setState({
      inputText: e.target.value,
      date2: date.valueOf(),
    });
  };

  onRemove = (index) => {
    const { todo } = this.state;
    // const nextTodo = todo.filter((td) => td.id !== id);
    this.setState({
      // todo: nextTodo,
      todo: todo.slice(0, index).concat(todo.slice(index + 1, todo.length)),
    });
  };

  onModify = (index) => {
    const { id, todo, inputText } = this.state;
    this.setState({
      todo: todo
        .slice(0, index)
        .concat({
          id: id,
          title: inputText,
          checked: false,
        })
        .concat(todo.slice(index + 1, todo.length)),
    });
  };

  onDouble = (id) => {
    const { todo } = this.state;
    const { title } = todo.filter((td) => td.id === id)[0];
    this.setState({
      inputText: title,
    });
  };

  render() {
    console.log(this.state);
    return (
      <div>
        <h1>일정 관리</h1>
        <TodoEditFormView
          onAddTodo={this.onAddTodo}
          onSetTodoProp={this.onSetTodoProp}
          onDouble={this.onDouble}
          inputText={this.state.inputText}
        />
        <TodoListView
          todo={this.state.todo}
          onRemove={this.onRemove}
          onModify={this.onModify}
          onDouble={this.onDouble}
          // onChecked={this.onChecked}
        />
      </div>
    );
  }
}

export default App;
