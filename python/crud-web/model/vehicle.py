from dataclasses import dataclass


@dataclass
class Vehicle:
    brand: str
    model: str
    color: str
    plate: str
    id: int | None = None
