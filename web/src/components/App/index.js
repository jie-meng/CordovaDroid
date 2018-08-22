import React, { Component } from 'react';
import { Redirect } from 'react-router';
import './App.css';

class App extends Component {
    constructor(props) {
      super(props);
      this.state = { navigate: null };
      if (window.location.href.endsWith('react.html')) {
        this.state.navigate = '/home';
      }
    }

  render() {
    const { navigate } = this.state;
    if (navigate) {
        this.state.navigate = null;
        return <Redirect to={navigate} push={false} />
    }

    return (
        <div/>
    );
  }
}

export default App;
