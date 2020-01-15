import React from 'react';
import Country from "./country"
import { connect } from 'react-redux';

class List extends React.Component{
	 
	constructor(props){
      super(props);
      this.state = {
			userList: Country,
			//arr:[]
      }
	 }
	 
    handleCheck(e){
			this.props.saveUserDetails('userarr', e);
            

	}

	render() {
		let filtercountry = this.state.userList.filter( function (user) {
			return JSON.parse(JSON.stringify(user.state)) === "Andhra_Pradesh"
		});
	
		return ( 
				<div >
                    <style>{"table,td,th{border:2px solid black;background-color:yellow;border-collapse: collapse;}"}</style>
                <div style={{
                    'wordBreak':'break-word',
                    'border':'1px solid black',
					'boxSizing' : "border-box",
					'width': "50%",
					'padding': "10px",
					'float':"left"}}>
                <table>
                    <tbody>
                    <th colspan='6' style={{'border': "2px solid white"}} >Normal Table</th>

                   <tr>
                   <th style={{"white-space": 'nowrap'}}>id</th>
                <th style={{"white-space": 'nowrap'}}>country</th>
                <th style={{"white-space": 'nowrap'}}>state</th>
                <th>city</th>
                <th>station</th>
                <th>last_update</th>
                   </tr>
				{filtercountry.map((d, idx) => {
				return (<tr  key={idx} onClick={() => this.handleCheck(d)} >
                <td style={{"white-space": 'nowrap'}}>{d.id}</td>
                <td style={{"white-space": 'nowrap'}}>{d.country}</td>
                <td style={{"white-space": 'nowrap'}}>{d.state}</td>
                <td>{d.city}</td>
                <td>{d.station}</td>
                <td>{d.last_update}</td>
               
                </tr>)
				})}
                 </tbody>
                </table>
				</div>

				<div style={{
                   'wordBreak':'break-word',
                    'border':'1px solid black',
					'boxSizing' : "border-box",
					'width': "50%",
					'padding': "10px",
					'float':"left"}}>
                        <table>

                    <tbody>
                    <th colspan='6'  style={{'border': "2px solid white"}} >REDUX Task</th>
                    <tr>
                   <th style={{"white-space": 'nowrap'}}>id</th>
                <th style={{"white-space": 'nowrap'}}>country</th>
                <th style={{"white-space": 'nowrap'}}>state</th>
                <th>city</th>
                <th>station</th>
                <th>last_update</th>
                   </tr>
				{this.props.arr.map((d, idx) => {
				return (<tr  key={idx}  >
                    <td style={{"white-space": 'nowrap'}}>{d.id}</td>
                    <td style={{"white-space": 'nowrap'}}>{d.country}</td>
                    <td style={{"white-space": 'nowrap'}}>{d.state}</td>
                    <td>{d.city}</td>
                    <td>{d.station}</td>
                    <td>{d.last_update}</td>
                    
                    </tr>)
				})}
                </tbody>
                </table>
				</div>
			</div>
		)
      }     
}

const mapStateToProps = (state) => {
	return{
		arr: state.userarr,
	}
}

const mapDispatchToProps = (dispatch) => {
	return{
		saveUserDetails: (name, val) => {dispatch({type: 'ADD_INFO', [name]: val})}
	}
}

export default connect(mapStateToProps, mapDispatchToProps)(List);
