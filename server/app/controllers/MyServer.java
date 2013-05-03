package controllers;


import play.Logger;
import play.libs.F;
import play.mvc.WebSocket;

public class MyServer {

    public static final Logger.ALogger LOGGER = Logger.of(MyServer.class);

    public static WebSocket<String> index() {
        return new WebSocket<String>() {
            @Override
            public void onReady(In<String> in, final Out<String> out) {
                in.onMessage(new F.Callback<String>() {
                    @Override
                    public void invoke(String message) throws Throwable {
                        out.write(message);
                        LOGGER.info("Received " + message);
                    }
                });

                in.onClose(new F.Callback0() {
                    @Override
                    public void invoke() throws Throwable {
                        LOGGER.info("Closing connection");
                    }
                });
                out.write("Hello!");
            }
        };
    }

    public static WebSocket<String> myserver(final String username) {
        return new WebSocket<String>() {
            @Override
            public void onReady(In<String> in, final Out<String> out) {
                in.onMessage(new F.Callback<String>() {
                    @Override
                    public void invoke(String s) throws Throwable {
                        LOGGER.info("Received " + s + " from " + username);
                    }
                });

                in.onClose(new F.Callback0() {
                    @Override
                    public void invoke() throws Throwable {
                    }
                });
                out.write("Hello: " + username);
            }
        };
    }
}
