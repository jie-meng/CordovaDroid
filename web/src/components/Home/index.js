import React from 'react';
import { Redirect } from 'react-router';
import classNames from 'classnames/bind';
import styles from './Home.scss'

const cx = classNames.bind(styles);

class Home extends React.Component {
    constructor(props) {
      super(props);
      this.state = { navigate: null };
    }

  render() {
    const { navigate } = this.state;
    if (navigate) {
        this.state.navigate = null;
        return <Redirect to={navigate} push={true} />
    }

    if (window.location.href.endsWith('/home')) {
        return (
              <div className={ cx('home') }>
                <header className={ cx('Home-header') }>
                  <img src='images/logo.svg' className={ cx('Home-logo') } alt="logo" />
                  <h1 className={ cx('Home-title') }>Welcome to React</h1>
                </header>
                <p className={ cx('Home-intro') }>
                  To get started, edit <code>src/App.js</code> and save to reload.
                </p>
                <button onClick={() => this.setState({ navigate: '/home/host' })}>
                    Go to Host
                </button>
                <button onClick={() => this.setState({ navigate: '/home/guest' })}>
                    Go to Guest
                </button>
                Home
              </div>
            );
    } else {
        return (<div/>);
    }
  }
}

export default Home;