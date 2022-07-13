import "./Banner.css"

function Banner(props){
    return(
        <h1 className="title">{props.title}</h1>
    );
}

export {Banner}