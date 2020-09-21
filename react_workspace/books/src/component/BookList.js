import React, { Component } from "react";
import { Item } from "semantic-ui-react";
import BookItem from "./BookItem";

class BookList extends Component {
  render() {
    // props 값 받아온다
    // for문 사용 대신 배열의 map을 이용해서 books의 아이템들을 가져온다
    // {}는 prop에서 정의된 속성 값을 가지고 오는 것이다
    // key={book.ISBN}는 책을 구분하기 위해 넣어줌 
    // map((book, index)={, key={index}로 대체해도 됨
    const bookList = this.props.books.map((book) => {
      return <BookItem key={book.ISBN} book={book} onSelect={this.props.onSelect} />;
    });

    return (
      <div>
        <Item.Group>{bookList}</Item.Group>
      </div>
    );
  }
}

export default BookList;
