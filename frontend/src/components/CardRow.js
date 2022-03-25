import React from "react";
import { api } from "../services/api";
import { Card, Row, Col } from "react-bootstrap";

export default (CardRow) => {
return (
    <Row xs={1} sm={2} md={4} lg={6}>
      {CardRow.data.map((item) => (
        <Col className="my-2">
          <Card>
            <Card.Body>
              <Card.Title>{item.nomeHeroi}</Card.Title>
              <Card.Text>
                This is a longer card with supporting text below as a natural
                lead-in to additional content. This content is a little bit
                longer.
              </Card.Text>
            </Card.Body>
          </Card>
        </Col>
      ))}
    </Row>
  );
};
