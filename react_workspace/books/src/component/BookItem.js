import React, { Component } from "react";
import { Item } from "semantic-ui-react";

class BookItem extends Component {
  render() {
    const { book, onSelect } = this.props; // props 값 받아온다
    // Item 영역 클릭되면 onSelect 호출
    return (
      <Item onClick={() => onSelect(book)}>
        <Item.Image size="tiny" src={book.imgUrl} />
        <Item.Content>
          <Item.Header as="a">{book.title}</Item.Header>
          <Item.Meta>{book.price}</Item.Meta>
          <Item.Description>{book.author}</Item.Description>
        </Item.Content>
      </Item>
    );
  }
}

export default BookItem;
