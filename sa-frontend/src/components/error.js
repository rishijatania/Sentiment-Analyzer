import React, { Component } from "react";
import MuiThemeProvider from "material-ui/styles/MuiThemeProvider";
import Paper from "material-ui/Paper";

class Error extends Component {
	
	render() {
		console.log(this.props.error)
		const errormessage= this.props.error.message
		return (
			<MuiThemeProvider>
				<div className="centerize">
					<Paper zDepth={1} className="content">
						<h2>CSYE 7220 Sentiment Analyser </h2>
						<p> {errormessage} </p>
					</Paper>
				</div>
			</MuiThemeProvider>
		);
	}
}
export default Error;
