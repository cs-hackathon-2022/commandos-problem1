import ReactDOM from "react-dom/client";
import {BrowserRouter, Routes, Route, Switch} from "react-router-dom";
import SignUp from "./components/signup/Signup";
import SignIn from "./components/signin/SignIn";
import Dashboard from "./components/dashboard/dashboard";
import React from "react";
import { withRouter } from "react-router";
const App= ()=> {
    return (
        <Switch>
            <Route path="/" render={(routeProps)=><Dashboard {...routeProps}/>}/>
            <Route exact path="/signup" render={(routeProps)=><SignUp {...routeProps} />}/>
            <Route exact path="/signin" render={(routeProps)=><SignIn {...routeProps} />}/>
        </Switch>
    );
}
export default withRouter(App)

