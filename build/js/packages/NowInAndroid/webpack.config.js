var config = {
  mode: 'development',
  resolve: {
    modules: [
      "node_modules"
    ]
  },
  plugins: [],
  module: {
    rules: []
  }
};

// entry
config.entry = {
    main: ["/home/dbdigital/akaStudio/projects/NowInAndroid/build/js/packages/NowInAndroid/kotlin/NowInAndroid.js"]
};

config.output = {
    path: "/home/dbdigital/akaStudio/projects/NowInAndroid/build/distributions",
    filename: (chunkData) => {
        return chunkData.chunk.name === 'main'
            ? "NowInAndroid.js"
            : "NowInAndroid-[name].js";
    },
    library: "NowInAndroid",
    libraryTarget: "umd",
};

// source maps
config.module.rules.push({
        test: /\.js$/,
        use: ["kotlin-source-map-loader"],
        enforce: "pre"
});
config.devtool = 'eval-source-map';

// dev server
config.devServer = {
  "inline": true,
  "lazy": false,
  "noInfo": true,
  "open": true,
  "overlay": false,
  "port": 8080,
  "contentBase": [
    "/home/dbdigital/akaStudio/projects/NowInAndroid/build/processedResources/Js/main"
  ]
};

// save evaluated config file
var util = require('util');
var fs = require("fs");
var evaluatedConfig = util.inspect(config, {showHidden: false, depth: null, compact: false});
fs.writeFile("/home/dbdigital/akaStudio/projects/NowInAndroid/build/reports/webpack/NowInAndroid/webpack.config.evaluated.js", evaluatedConfig, function (err) {});

module.exports = config
