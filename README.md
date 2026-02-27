# Discrete Event Simulation of Patient Flow in a Hospital Emergency Department

## Project Status

This project implements a discrete event simulation of patient flow in a hospital emergency department. The simulation models patient arrivals, queueing behavior, treatment by medical staff, and discharge.

### Currently Implemented

- Discrete event scheduling using a `PriorityQueue`
- Poisson arrival process modeled using exponential interarrival times
- M/M/c queueing model with configurable number of doctors
- Exponential service time distribution
- Performance metrics collection:
  - Average patient wait time
  - Doctor utilization
  - Total patients served

### Remaining Work

- Additional performance metrics
- Experimental scenario comparisons
- Data export and analysis for Milestones 3 and 4
- Extended validation and testing

No major architectural changes were made from the Milestone 1 proposal

## Installation Instructions

### Requirements

- Java 17 or newer
- IntelliJ IDEA

### Setup Steps

1. Clone the repository: 
2. Open the project in IntelliJ.
3. Ensure the `src` folder is marked as Sourecs Root.
4. Run `Main.java`.

## Usage

Simulation parameters are configured in `Main.java`:

- `doctors` → number of medical staff
- `arrivalRate` → patients per hour
- `serviceRate` → patients served per hour per doctor
- `simulationTime` → total simulation duration in hours


### Output

The simulation outputs:

- Total patients served
- Average wait time (in minutes)
- Doctor utilization

Changing arrival or service rates allows testing different demand and staffing scenarios

## Architecture Overview

The system follows a discrete event simulation structure

### Core Components

- **SimulationEngine**  
  Controls event scheduling and processes events in chronological order.

- **EmergencyDepartment**  
  Manages queue logic, doctor availability, and service handling.

- **Event / EventType**  
  Represents arrival and service completion events.

- **Patient**  
  Represents individual entities in the simulation.

- **Statistics**  
  Collects and stores performance metrics.

The implementation directly reflects the UML design proposed in Milestone 1, including event based state transitions and queue management logic.

## Version Control and Development

Development has followed an iterative approach with multiple meaningful commits reflecting incremental progress:

- Initial simulation framework implementation
- Queue model implementation
- Metrics integration
- Parameter adjustments and utilization correction
