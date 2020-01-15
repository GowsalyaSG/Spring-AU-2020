const initState = {
	userarr:[]
}

const userinfo = (state = initState, action) => {
	if(action.type === 'ADD_INFO') {
		if(action.userarr){
			console.log("inside reducer", action);
			return {
			...state,
			userarr: state.userarr.concat(action.userarr)
			}	
		}		
	}
	return state;
}

export default userinfo;