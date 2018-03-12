const path = require('path');

module.exports = {
  entry: './scripts/main.js',

  output: {
    path: path.resolve(__dirname, 'public'),
    filename: 'scripts/bundle.js'
  },

  devtool: 'inline-source-map',
  devServer: {
    contentBase: './dist'
  },

  module: {
   rules: [
     {
       test: /\.js$/,
       exclude: (/node_modules/),
       loader: ['babel-loader']
     },
     {
        test: /\.css$/,
        use: [
          { loader: 'style-loader'},
          { loader: 'css-loader'}
        ]
      },
     {
       test: /\.(png|jpg|gif)$/,
       use: [
         {
           loader: 'file-loader',
           options: {outputPath : 'images/img'}
         }
       ]
     }
   ]
 }
};
