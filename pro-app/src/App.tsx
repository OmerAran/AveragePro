import React, { Component } from 'react';
import './App.css';

class App extends Component {

  render() {

    async function callExpress() {
      try {
        let response = await fetch('/avgsalary/3')
                              .then(res => res.json());
        alert('Hi this is a response from the backend: ' + response.response);
      } catch (err) {
        alert(err);
      }
    }

    callExpress();

    return (
      <div className="App">
        <header className="App-header">
        
        </header>
      </div>
    );
  }

}

export default App;
