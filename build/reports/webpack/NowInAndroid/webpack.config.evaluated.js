{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'kotlin-source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: {
    main: [
      '/home/dbdigital/akaStudio/projects/NowInAndroid/build/js/packages/NowInAndroid/kotlin/NowInAndroid.js'
    ]
  },
  output: {
    path: '/home/dbdigital/akaStudio/projects/NowInAndroid/build/distributions',
    filename: [Function: filename],
    library: 'NowInAndroid',
    libraryTarget: 'umd'
  },
  devtool: 'eval-source-map',
  devServer: {
    inline: true,
    lazy: false,
    noInfo: true,
    open: true,
    overlay: false,
    port: 8080,
    contentBase: [
      '/home/dbdigital/akaStudio/projects/NowInAndroid/build/processedResources/Js/main'
    ]
  }
}