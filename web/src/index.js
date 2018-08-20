//import React from 'react';
//import ReactDOM from 'react-dom';
//import './index.css';
//import App from './App';
//import registerServiceWorker from './registerServiceWorker';
//
//ReactDOM.render(<App />, document.getElementById('root'));
//registerServiceWorker();

import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom'
import ReactDOM from 'react-dom';
import App from './components/App';
import Home from './components/Home';
import Host from './components/Host';
import Guest from './components/Guest';

ReactDOM.render((
    <Router>
        <div>
            <Route path="/" component={App} />
            <Route path="/home" component={Home} />
            <Route path="/host" component={Host} />
            <Route path="/guest" component={Guest} />
        </div>
    </Router>
), document.getElementById('root'));