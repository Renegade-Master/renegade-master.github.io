// Use this file for any Webpack configuration you want to apply to all environments.
const path = require('path');

module.exports = {
    module: {
        rules: [
            {
                test: /\.properties$/,
                loader: 'messageformat-properties-loader',
                options: {
                    biDiSupport: false,     // enables bi-directional text support
                    defaultLocale: 'en',    // used if resolution from filename fails
                    encoding: 'auto',       // .properties file encoding, use one of
                                            // 'auto', 'latin1', or 'utf8'
                    keyPath: true,          // if true, dots '.' key names will result
                                            // in multi-level objects -- use a string
                                            // value to customize
                    pathSep: '_'            // separator for parsing locale from filename
                }
            }
        ]
    }
};

// config.resolve = {
//     modules: [
//         path.resolve("src/main/resources")
//     ]
// };

// config.module.rules.push(
//     {
//         test: /\.(properties)$/i,
//         type: 'asset/resource'
//     }
// );

// module.exports = {
//     mode: 'development',
//     resolve: {
//         modules: [
//             path.resolve("src/jsMain/resources")
//         ]
//     },
//     module: {
//         rules: [
//             {
//                 // "include" is commonly used to match the directories
//                 test: [/\.properties$/],
//                 include: [
//                     path.resolve("src/jsMain/resources")
//                 ],
//                 // type: 'javascript/auto', // required by Webpack for JSON files
//                 //loader: '@messageformat/loader',
//                 // options: {locale: ['de', 'en', 'fr']}
//             }
//         ]
//     }
// };

// module.exports = {
//     module: {
//         rules: [
//             {
//                 // test: /\.css$/,
//                 include: [
//                     // will include any paths relative to the current directory starting with `app/styles`
//                     // e.g. `app/styles.css`, `app/styles/styles.css`, `app/stylesheet.css`
//                     // path.resolve(__dirname, 'app/styles'),
//                     // add an extra slash to only include the content of the directory `vendor/styles/`
//                     path.join(__dirname, 'src/jsMain/resources/'),
//                 ],
//             },
//         ],
//     },
// };
