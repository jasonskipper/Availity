import React from 'react';

export default class Form extends React.Component {
    state = {
        firstName: '',
        lastName: '',
        NPInumber: '',
        businessAddress: '',
        telephoneNumber: '',
        emailAddress: '',
    }
    onSubmit =  (e) => {
        e.preventDefault()
        console.log(this.state)
    }
    render() {
        return (
            <form>
                <input 
                placeholder='First Name'
                value={this.state.firstName}
                onChange = {e => this.setState({ firstName: e.target.value})}
                />
                <br />
                <input 
                placeholder='Last Name'
                value={this.state.lastName}
                onChange = {e => this.setState({ lastName: e.target.value})}
                />
                <br />
                <input 
                placeholder='NPI Number'
                value={this.state.NPInumber}
                onChange = {e => this.setState({ NPInumber: e.target.value})}
                />
                <br />
                <input 
                placeholder='Business Address'
                value={this.state.businessAddress}
                onChange = {e => this.setState({ businessAddress: e.target.value})}
                />
                <br />
                <input 
                placeholder='Telephone Number'
                value={this.state.telephoneNumber}
                onChange = {e => this.setState({ telephoneNumber: e.target.value})}
                />
                <br />
                <input 
                placeholder='Email Address'
                value={this.state.emailAddress}
                onChange = {e => this.setState({ emailAddress: e.target.value})}
                />
                <br />
                <button onClick={e => this.onSubmit(e)}>
                    Submit
                </button>
            </form>
        );
    }
}