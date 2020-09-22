import React, { PureComponent } from 'react';
import { Table, Button, Form } from 'semantic-ui-react';
import moment from 'moment';

class TodoListView extends PureComponent {
  render() {
    //
    const { todo, onRemove, onModify, onDouble } = this.props;

    return (
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Check</Table.HeaderCell>
            <Table.HeaderCell>Title</Table.HeaderCell>
            <Table.HeaderCell>Date</Table.HeaderCell>
            <Table.HeaderCell>Modify</Table.HeaderCell>
            <Table.HeaderCell>Remove</Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {Array.isArray(todo) && todo.length ? (
            todo.map((td, index) => {
              return (
                <Table.Row key={td.id}>
                  <Table.Cell>
                    <Form.Checkbox
                      // checked={td.checked ? true : false}
                      // onClick={() => onChecked(td.id)}
                    />
                  </Table.Cell>
                  <Table.Cell onDoubleClick={() => onDouble(td.id)}>
                    {td.title}
                  </Table.Cell>
                  <Table.Cell>
                    {moment(td.date).format('YYYY-MM-DD HH:mm')}
                  </Table.Cell>
                  <Table.Cell>
                    <Button onClick={() => onModify(index)}>수정</Button>
                  </Table.Cell>
                  <Table.Cell>
                    <Button onClick={() => onRemove(index)}>삭제</Button>
                  </Table.Cell>
                </Table.Row>
              );
            })
          ) : (
            <Table.Row>
              <Table.Cell>Empty</Table.Cell>
            </Table.Row>
          )}
        </Table.Body>
      </Table>
    );
  }
}

export default TodoListView;
