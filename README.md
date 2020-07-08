# Dynmap-OCC


Dynmap-OCC is a Dynmap addon which provides online control to TrainCarts trains. It acts similarly to the real-life Operation Control Centre.

**This addon is in alpha stage and it is a proof-of-concept project, bugs/errors/security issues are expected, do not use it directly on production server.**

**This addon requires Dynmap external server. For more information please visit https://github.com/webbukkit/dynmap/wiki/Setting-up-without-the-Internal-Web-Server**

**This addon might not work with Dynmap internal server.**

## Installation

**This addon is developed based on Spigot 1.14.4, you may use other versions at your own risk.**

- Install XAMPP (Apache required)
- Download all files
- Locate `Your server directory/server.properties`
- Copy `server.properties` from `Dynmap-OCC/Server/server.properties` (or compare 2 files and modify all rcon options)
- Copy `Dynmap-OCC/Server/plugins` into `Your server directory/plugin`
(You may want to download all dependencies yourself, in this case, you should copy `Dynmap-OCC/Server/plugins/Dynmap-OCC` folder and `Dynmap-OCC/Server/plugins/Dynmap-OCC/Dynmap-OCC.jar` only)
- Copy `Dynmap-OCC/web` into `Your XAMPP directory/htdocs/
- Modify `command.php` and `index.php` `$Query->SetRconPassword('password you have set in server.properties');`
- Start the server
- Start the web server



## Known Bugs

Sometimes HTML input disappears when the marker is clicked, you have to reload the plugin to make it appear again



## Concept

The plugin control train properties with commands, with PHP-Source-Query, you can run commands with it (rcon in server.properties required).

PHP-Source-Query can be found here https://github.com/xPaw/PHP-Source-Query

Dynmap markers description support HTML code, so we can make use of it to make Dynmap interactable.



## **Terms of Use**
- You are allowed to download the source code, compile and install on your own device.
- You are not allowed to redistribute any part of the code and claim that is your work.
