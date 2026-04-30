# Discrete Event Simulation of Patient Flow in a Hospital Emergency Department

## Project Description

This project is a discrete event simulation of patient flow in a hospital emergency department. The simulation models patients arriving at the emergency department, waiting if all doctors are busy, receiving treatment, and then leaving the system.

The purpose of the simulation is to test how different parameters affect emergency department performance. The main parameters are the number of doctors, patient arrival rate, service rate, and simulation time. The simulation outputs performance metrics such as patients served, average wait time, doctor utilization, maximum queue length, average queue length, and patients left in the queue at the end of the run.

This project was created for CS 4632 Modeling and Simulation.

---

## Installation Instructions

1. Clone the repository:

```bash
git clone https://github.com/jakew2210/Modeling_simulation_jakewalker.git
```

2. Open the project in IntelliJ IDEA or another Java IDE.

3. Make sure the Java JDK is installed.

4. Open `Main.java`.

5. Run the `main` method.

No external libraries are required. The project uses standard Java libraries.

---

## Usage Guide

The simulation parameters are set in `Main.java`.

Example:

```java
int doctors = 3;
double arrivalRate = 15.0;
double serviceRate = 6.0;
double simulationTime = 12.0;
```

To run a different scenario, change one or more of these values and run the program again.

For example, to test a higher patient arrival rate, change:

```java
double arrivalRate = 20.0;
```

To test more doctors, change:

```java
int doctors = 4;
```

After running the program, the output will show the simulation results in the console.

---

## Parameter Explanations

| Parameter | Meaning | Example |
|---|---|---|
| `doctors` | Number of doctors available to treat patients | `3` |
| `arrivalRate` | Average number of patients arriving per hour | `15.0` |
| `serviceRate` | Average number of patients one doctor can treat per hour | `6.0` |
| `simulationTime` | Total amount of time the simulation runs, measured in hours | `12.0` |

---

## Example Output

```text
==================================
Emergency Department Simulation
==================================
Doctors: 3
Arrival rate: 15.0 patients/hour
Service rate: 6.0 patients/hour
Simulation time: 12.0 hours
----------------------------------
Patients served: 204
Average wait time: 10.00 minutes
Doctor utilization: 92.00%
Maximum queue length: 15
Average queue length: 2.85
Patients left in queue at end: 2
==================================
```

---

## Author

Jake Walker  
CS 4632 Modeling and Simulation  
Kennesaw State University
