import logo from './logo.svg';
import './App.css';
import {Component} from "react";


class App extends Component {
    state = {
        questions: [],
        answers: []
    };

    async componentDidMount() {
        const response = await fetch('/questions');
        const body = await response.json();
        this.setState({questions: body});
        this.setState({answers: body});
    }



    render() {
        const {questions, answers} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Questions</h2>
                        {questions.map(question =>
                            <div key={question.id}>
                                {question.title}
                            </div>
                        )}
                        <h2>Answers</h2>
                        {answers.map(answer =>
                            <div key={answer.id}>
                                {answer.input}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;