import React, { Component } from "react";
import "./App.css";
import Sentiment from "./components/sentiment";
import Error from "./components/error";

const WEBAPP_URL =
	process.env.WEBAPP_URL == null
		? "http://localhost:8080"
		: process.env.WEBAPP_URL;
class App extends Component {
	constructor(props) {
		super(props);
		this.state = {
			healthcheckOk: false,
			errorMessage: "",
		};
	}

	// componentWillMount() {
	// 	fetch(`${WEBAPP_URL}/testHealth`, {
	// 			method: "GET",
	// 			headers: { "Content-Type": "application/json" }
	// 		}
	// 	).then((response) => {
	// 			if(!response.ok) {
	// 				this.setState({ errorMessage: response.body})
	// 				this.setState({ healthcheckOk: false})
	// 			}
	// 			else {
	// 				fetch(`${WEBAPP_URL}/testComms`, {
	// 						method: "GET",
	// 						headers: { "Content-Type": "application/json" }
	// 					}
	// 				).then((response) => {
	// 					if(!response.ok) {
	// 						response.json().then(body => {
	// 							this.setState({ errorMessage: body})
	// 						})
	// 						this.setState({ healthcheckOk: false})
	// 					}
	// 					else{
	// 						this.setState({ healthcheckOk: true})
	// 					}
	// 				})
	// 			}
	// 	}).catch(error=>{
	// 		error.message = 'Middleware Services are down.'
	// 		this.setState({ errorMessage: error})
	// 		this.setState({ healthcheckOk: false})
	// 	});
	// }

	render() {
		// if(this.state.healthcheckOk){
		return <Sentiment />;
		// }
		// else{
		// 	return(<Error error ={this.state.errorMessage} />)
		// }
	}
}

export default App;
