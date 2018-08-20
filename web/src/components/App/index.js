import React, { Component } from 'react';
import { Redirect } from 'react-router'
import './App.css';

class App extends Component {
    constructor(props) {
      super(props);
      this.state = { navigate: null };
    }

  render() {
    const { navigate } = this.state;

    if (navigate) {
    let url = '/' + navigate;
      return <Redirect to={url} push={true} />
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src='images/logo.svg' className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        <button onClick={() => this.setState({ navigate: 'home' })}>
            Go to Home
        </button>
        <button onClick={() => this.setState({ navigate: 'host' })}>
            Go to Host
        </button>
        <button onClick={() => this.setState({ navigate: 'guest' })}>
            Go to Guest
        </button>
      </div>
    );
  }
}

export default App;
