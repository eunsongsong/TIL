import React, { Component } from "react";
import { Card, Image } from "semantic-ui-react";

class BookDetails extends Component {
  render() {
    // App에서 book이라는 속성 값을 props로 전달하기 때문에 {}으로 감싼다
    const { book } = this.props; // props 데이터 받아온다
    return (
      <div>
        <Card>
          <Image src={book.imgUrl} wrapped ui={false} />
          <Card.Content>
            <Card.Header>{book.title}</Card.Header>
            <Card.Meta>
              <span className="date">
                {book.author}&nbsp;{book.publisher} {/* &nbsp;는 공백문자 */}
              </span>
              <span className="date">{book.price}</span>
            </Card.Meta>
            <Card.Description>{book.introduce}</Card.Description>
          </Card.Content>
        </Card>
      </div>
    );
  }
}

export default BookDetails;
