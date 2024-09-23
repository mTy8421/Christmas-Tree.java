# CLI Cheat Sheet

Docker ให้ความสามารถในการแพ็คเกจและรันแอปพลิเคชันในอินเทอร์เฟซที่ไม่แน่นอน และแบ่งออกจากกันได้ เรียกว่า "Container"
การแยกส่วนและความปลอดภัยนี้ทำให้คุณสามารถรันคอนเทนเนอร์หลายตัวพร้อมกันบนเครื่องคอมพิวเตอร์เดียวกันได้ คอนเทนเนอร์มีขนาดเล็กและมีรายละเอียดทุกอย่างที่จำเป็นในการรันแอปพลิเคชัน โดยไม่เชื่อถือว่าเครื่องมือและซอฟต์แวร์ทั้งหมดที่กำลังใช้งานอยู่บนเครื่องคอมพิวเตอร์ (Host) คุณสามารถแบ่งปันคอนเทนเนอร์ได้ง่ายๆ ในขณะที่ทำงาน และแน่นอนว่าทุกคนจะรับคอนเทนเนอร์ที่เหมือนกันและทำงานในแบบเดียวกัน

# การติดตั้ง

[Docker Desktop](https://docs.docker.com/desktop/) พร้อมใช้งานสำหรับ Mac, Linux และ Windows  
ดูตัวอย่าง Project ที่ใช้ [Docker](https://github.com/docker/awesome-compose)  
เอกสารเพื่อดูข้อมูลเกี่ยวกับการใช้ [Docker](https://docs.docker.com/)

# IMAGES

Docker Image เป็นแพ็คเกจที่มีขนาดเล็กและสามารถใช้งานได้อย่างอิสระ ซึ่งรวมเอาเนื้อหาทั้งหมดที่จำเป็นในการรันแอปพลิเคชัน เช่น :

- code
- runtime
- system tools
- system libraries
- settings

```bash
# Build Image สำหรับ Dockerfile
docker build -t <image_name>
# Build an Image สำหรับ Dockerfile (ไม่มีแคช)
docker build -t <image_name> . –no-cache
# List local images
docker images
# ลบ Image
docker rmi <image_name>
# ลบ images ไม่ได้ใช้ทั้งหมดออก
docker image prune
```

# DOCKER HUB

[Docker Hub](https://hub.docker.com/) เป็นบริการของ Docker ที่ช่วยให้คุณสามารถค้นหา Container Images และ แบ่งปันร่วมกับทีมของคุณได้

```bash
# Login Docker
docker login -u <username>
# Publish an image to Docker Hub
docker push <username>/<image_name>
# ค้นหา Hub สำหรับ image
docker search <image_name>
# Pull an image จาก Docker Hub
docker pull <image_name>
```

# GENERAL COMMANDS

```bash
# Start the docker daemon
docker -d
# Get help with Docker. Can also use –help on all subcommands
docker --help
# Display system-wide information
docker info
```

# CONTAINERS

Container คืออินสแตนซ์ที่สามารถทำงานได้จริงของ Docker Image Container จะทำงานในแบบเดียวกันเสมอ ไม่ว่าจะอยู่บนอุปกรณ์ใดๆ
Container ใช้แยกซอฟต์แวร์ออกจากสภาพแวดล้อมของมัน และรับประกันว่าซอฟต์แวร์นั้นจะทำงานได้อย่างเป็นเอกลักษณ์ แม้ว่าจะอยู่ในสถานการณ์ที่แตกต่างกัน เช่น จากการพัฒนาไปสู่การทดสอบ (staging)

```bash
# Create and run a container from an image, with a custom name:
docker run --name <container_name> <image_name>
# Run a container with and publish a container’s port(s) to the host.
docker run -p <host_port>:<container_port> <image_name>
# Run a container in the background
docker run -d <image_name>
# Start or stop an existing container:
docker start|stop <container_name> (or <container-id>)
# Remove a stopped container:
docker rm <container_name>
# Open a shell inside a running container:
docker exec -it <container_name> sh
# Fetch and follow the logs of a container:
docker logs -f <container_name>
# To inspect a running container:
docker inspect <container_name> (or <container_id>)
# To list currently running containers:
docker ps
# List all docker containers (running and stopped):
docker ps --all
# View resource usage stats
docker container stats
```
