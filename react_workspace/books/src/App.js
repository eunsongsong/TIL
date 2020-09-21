import React, { Component } from "react";
import { Grid } from "semantic-ui-react";
import BookDetails from "./component/BookDetails";
import Books from "./Books";
import BookList from "./component/BookList";
// import { render } from "react-dom";

class App extends Component {
  constructor(props) {
    super(props);
    // 사용할 데이터 초기화
    this.state = {
      books: Books, // 사용할 데이터 Books.js를 먼저 import 해줘야 함(line4)
      selectBook: Books[0],
    };
  }

  // 화살표 함수(람다 함수) 사용하는 이유
  // 화면에 이미 뿌려진 상태에서 이벤트 발생하는 시점
  // 이미 렌더링된 상태에서 this를 인식하기 위해 
  handleSelectBook = (book) => {
    this.setState({
      selectBook: book,
    });
  };

  render() {
    // Grid로 화면 구성
    // 열 두개
    // 첫 번째 열에는 책 목록
    // 두 번째 열에는 선택된 책의 상세 정보
    return (
      <Grid columns={2} divided>
        <Grid.Column>
          <BookList books={this.state.books} onSelect={this.handleSelectBook} />
        </Grid.Column>
        <Grid.Column>
          <BookDetails book={this.state.selectBook} />
        </Grid.Column>
      </Grid>
    );
  }
}

export default App;
