import React from "react";
import { observer } from "mobx-react";
import { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./view/menu/Home";
import Login from "./view/menu/Login";
import TodoMain from "./view/menu/TodoMain";
import BookMain from "./view/menu/BookMain";

@observer
class App extends Component {
  render() {
    return (
      <Router>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/books">Book</Link>
          </li>
          <li>
            <Link to="/todos">Todo</Link>
          </li>
          <li>
            <Link to="/login">Login</Link>
          </li>
        </ul>

        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/books" component={BookMain} />
          <Route exact path="/todos" component={TodoMain} />
          <Route exact path="/login" component={Login} />
        </Switch>
      </Router>
    );
  }
}

export default App;
