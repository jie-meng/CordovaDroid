const path = require('path');

const BUILD_DIR = path.resolve(__dirname, 'www');
const APP_DIR = path.resolve(__dirname, 'src');

const config = {

   "entry": `${APP_DIR}/index.js`,
   "output": {
       "path": BUILD_DIR,
       "filename": 'bundle.js'
   },
   "module": {
       "rules": [
           {
               "test": /\.(js|jsx)$/,
               "exclude": /node_modules/,
               "use": {
                   "loader": "babel-loader",
                   "options": {
                       "presets": [
                           "env",
                           "react"
                       ]
                   }
               }
           },
           {
               "test": /\.(css|scss)$/,
               "use": [
                   "style-loader",
                   "css-loader",
                   "sass-loader"
               ]
           }
       ]
   },
   resolve: {
       extensions: ['.js', '.jsx'],
   },
   devtool: 'eval'
};

module.exports = config;

