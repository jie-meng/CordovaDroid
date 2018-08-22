import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import ReactDOM from 'react-dom';
import Storage from './data/Storage';
import App from './components/App';
import Home from './components/Home';
import Host from './components/Host';
import Guest from './components/Guest';

let index = window.location.href.indexOf('/www');
if(index >= 0) {
    Storage.setLocalhostUrl(window.location.href.substring(0, index + 4));
}

ReactDOM.render((
    <Router>
        <div>
            <Route path="/" component={App} />
            <Route path="/home" component={Home} />
            <Route path="/home/host" component={Host} />
            <Route path="/home/guest" component={Guest} />
        </div>
    </Router>
), document.getElementById('root'));