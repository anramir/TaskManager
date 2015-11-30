var Task = React.createClass({displayName: "Task",
	deleteTask:function(){
		var id = this.props.id;
		var commentUrl = "http://localhost:9000/removeTask?identifier=" + id;
	    $.ajax({
	          url: commentUrl,
	          method: 'POST',
	          dataType: 'html',
	          cache: false,
	          success: function(data) {
	            console.log(data)
	          }.bind(this),
	          error: function(xhr, status, err) {
	            console.error(commentUrl, status, err.toString());
	          }.bind(this)
	        });
	    return;
	},
	getInitialState:function(){
		return{fondo:this.props.color,text:this.props.text};
	},	
	render: function(){
		var style = {backgroundColor:this.state.fondo, color:this.state.text}
		var longitud = {width:'75%', display:'inline-block'}
		var dibujo = {width:'3%', display:'inline-block'}
		return(
			React.createElement("div", {className: "task", style: style}, 
				React.createElement("div", {style: longitud}, this.props.task, " "), 
				React.createElement(StatusSelect, {id: this.props.id, status: this.props.status, color: this.state.fondo}), 
				React.createElement("div", {style: dibujo, onClick: this.deleteTask}, 				
					React.createElement("svg", {height: "12pt", viewBox: "0 0 214.15626 241.04342", display: "block"}, 
						 React.createElement("g", {transform: "translate(-312.23 -179.46)"}, 
						  React.createElement("path", {d: "m502.62 418.95c-35.527-7.0588-72.453-31.738-102.41-68.445-4.7129-5.775-8.874-10.863-9.247-11.306-0.37298-0.4434-5.1304 3.5466-10.572 8.8666-35.329 34.54-45.264 41.812-54.698 40.042-4.5816-0.8595-8.0965-3.7241-11.321-9.2267-4.5824-7.8193-2.3632-13.824 11.821-31.985 10.602-13.574 19.708-23.988 34.249-39.169 2.7804-2.9027 5.2036-5.7102 5.3849-6.239 0.18131-0.5287-2.5857-6.7038-6.149-13.722-12.362-24.349-26.513-60.514-29.18-74.57-2.3663-12.474-0.58504-19.249 6.8293-25.973 8.4712-7.6832 18.103-9.972 23.01-5.4682 1.7722 1.6265 4.4491 8.2079 9.6603 23.75 11.579 34.533 24.183 65.309 25.953 63.372 0.43802-0.4794 2.9496-3.3466 5.5814-6.3716 21.507-24.721 56.93-60.576 60.807-61.55 6.3678-1.5982 18.128 4.2614 23.159 11.539 2.3887 3.4556 3 5.3955 3 9.5202 0 4.4936-0.61138 6.0954-4.6129 12.086-7.9627 11.92-37.101 45.714-59.387 68.876-1.1 1.1432-3.2901 3.497-4.8669 5.2305l-2.8669 3.1519 3.7953 6.3232c6.4512 10.748 12.563 18.865 13.683 18.172 0.6205-0.3835 0.77203-0.1848 0.36336 0.4764-0.58579 0.9479 3.7091 7.6677 9.0183 14.11 0.70926 0.8606 2.6654 3.3229 4.347 5.4716 8.638 11.038 28.848 30.384 43.586 41.722 7.8621 6.0488 21.957 15.871 22.774 15.871 0.2332 0 3.0395 1.575 6.2363 3.5l5.8123 3.5-8.4411-0.094c-4.6427-0.052-11.536-0.7089-15.32-1.4606z"})
						 )
					)
				)				
			)
			);
	}

});

var StatusSelect = React.createClass({displayName: "StatusSelect",
	updateTask:function(e){
		console.log("He entrado por aqui")
		e.preventDefault();
    	var status = React.findDOMNode(this.refs.status).value.trim();
    	var id = this.props.id
    	if (!status) {
      		return;
    	}
	   	var commentUrl = "http://localhost:9000/updateTask?identifier=" + id + "&status=" + status;
	    $.ajax({
	          url: commentUrl,
	          method: 'POST',
	          dataType: 'html',
	          cache: false,
	          success: function(data) {
	            console.log(data)
	          }.bind(this),
	          error: function(xhr, status, err) {
	            console.error(commentUrl, status, err.toString());
	          }.bind(this)
	        });

	    
	    
	    
	    return;
	},

	getInitialState:function(){
		return{status:this.props.status,color:this.props.color}
	},

	componentDidMount:function(){
		this.setState({status:this.props.status});
		this.setState({color:this.props.color});
		React.findDOMNode(this.refs.status).value = this.state.status;
		console.log("Hasta aqui si he llegado")
	},

	render: function(){
		var style = {width:"20%",display:'inline-block',height:"100%"}
		var selectorStyle = {backgroundColor:this.state.color,border:"none"}

		return(				
			React.createElement("div", {className: "satusSelect", style: style}, 			
				React.createElement("select", {name: "taskStatus", style: selectorStyle, ref: "status"}, 
					React.createElement("option", {value: "Pendiente", onClick: this.updateTask}, " Pendiente "), 
					React.createElement("option", {value: "En camino", onClick: this.updateTask}, " En camino "), 
					React.createElement("option", {value: "Acabado", onClick: this.updateTask}, " Acabado ")
				)
			)
			);
	}

});

var TaskList = React.createClass({displayName: "TaskList",
	render:function(){
		var texto= this.props.text
		var fondo= this.props.color
		var listadoTareas = this.props.data.map(function(tarea){
							
				return(
					React.createElement(Task, {task: tarea.task, color: fondo, text: texto, id: tarea._id, status: tarea.status}));
			});
		var style = {backgroundColor:fondo, color:texto}
		return(
			React.createElement("div", {className: "taskList"}, 
				React.createElement("h1", {style: style}, " ", this.props.lista), 
				listadoTareas
			)
			);
	}
});



var TaskDashboard = React.createClass({displayName: "TaskDashboard",
	loadTasksFromServer: function() {
    $.ajax({
      url: this.props.url,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({pendientes: data.filter(function(json){return (json.status==="Pendiente");})});
        this.setState({ongoing: data.filter(function(json){return json.status=="En camino";})});
        this.setState({acabados: data.filter(function(json){return json.status=="Acabado";})});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
   		 });
  	},
  getInitialState: function() {
    return {pendientes:[],ongoing:[],acabados:[]};
  },
  componentDidMount: function() {
    this.loadTasksFromServer();
    setInterval(this.loadTasksFromServer, this.props.pollInterval);
  },
	render: function(){
		var style = {backgroundImage: 'url("/web/assets/images/background.jpg")'}
		return(
			React.createElement("div", {className: "taskDashboard", style: style}, 
				React.createElement(TaskForm, null), 
				React.createElement(TaskList, {lista: "Pendiente", data: this.state.pendientes, color: "#FE2E2E", text: "white"}), 
				React.createElement(TaskList, {lista: "En camino", data: this.state.ongoing, color: "#886A08", text: "white"}), 
				React.createElement(TaskList, {lista: "Acabado", data: this.state.acabados, color: "#31B404", text: "white"})
			)
			);
	}
});

var TaskForm = React.createClass({displayName: "TaskForm",
	addTask:function(e){
		e.preventDefault();
		var tarea = React.findDOMNode(this.refs.tarea).value.trim();
    	var status = React.findDOMNode(this.refs.status).value.trim();
    	if (!tarea || !status) {
      		return;
    	}
	   	var commentUrl = "http://localhost:9000/addTask?task=" + tarea + "&status=" + status;
	    $.ajax({
	          url: commentUrl,
	          method: 'POST',
	          dataType: 'html',
	          cache: false,
	          success: function(data) {
	            console.log(data)
	          }.bind(this),
	          error: function(xhr, status, err) {
	            console.error(commentUrl, status, err.toString());
	          }.bind(this)
	        });

	    // clears the form fields
	    React.findDOMNode(this.refs.tarea).value = '';
	    React.findDOMNode(this.refs.status).value = 'Pendiente';
	    return;
	},

	render: function(){
		return(
			React.createElement("form", {className: "taskForm", onSubmit: this.addTask}, 
				React.createElement("input", {type: "text", placeholder: "Indica qué tarea quieres agregar", ref: "tarea"}), 
				React.createElement("select", {name: "taskStatus", ref: "status"}, 
					React.createElement("option", {value: "Pendiente"}, " Pendiente "), 
					React.createElement("option", {value: "En camino"}, " En camino "), 
					React.createElement("option", {value: "Acabado"}, " Acabado ")
				)
			)
			);
	}

});

React.render(
	React.createElement(TaskDashboard, {url: "http://localhost:9000/tasks", pollInterval: 1000}),
	document.getElementById('content')
	);