import React from 'react';
import classNames from 'classnames/bind';
import styles from './Home.scss'

const cx = classNames.bind(styles);

class Home extends React.Component {
  render() {
    return (
        <div className={ cx('home') }>
            Home
        </div>
    );
  }
}

export default Home;