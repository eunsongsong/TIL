import React, { PureComponent } from 'react';
import { Form, Button } from 'semantic-ui-react';
import DatePicker from 'react-datepicker';
import moment from 'moment';

class TodoEditFormView extends PureComponent {
  render() {
    //
    const { inputText, todo, onSetTodoProp, onAddTodo } = this.props;

    return (
      <Form>
        <Form.Group widths="equal">
          <Form.Input
            fluid
            label="&nbsp;&nbsp;Title"
            placeholder="일정을 입력하세요."
            // value={todo && todo.title ? todo.title : ''}
            // onChange={(e) => onSetTodoProp('title', e.target.value)}
            value={inputText}
            onChange={onSetTodoProp}
          />
          <Form.Field>
            <label>&nbsp;&nbsp;Date</label>
            <DatePicker
              // showTimeSelect
              selected={todo && todo.date ? moment(todo.date) : null}
              dateFormat="YYYY-MM-DD HH:mm"
              timeFormat="HH:mm"
              timeIntervals={15}
              onChange={onSetTodoProp}
              // onChange={(date) => onSetTodoProp('date', date.valueOf())}
            />
          </Form.Field>
        </Form.Group>
        <Button primary onClick={onAddTodo}>
          Add
        </Button>
      </Form>
    );
  }
}

export default TodoEditFormView;
