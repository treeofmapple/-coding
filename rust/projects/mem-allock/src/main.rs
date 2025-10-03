use std::alloc::{alloc, dealloc, Layout};
use std::thread;
use std::time::Duration;
use std::slice;

fn main() {

    let size: usize = 1024 * 1024 * 1024;
    let layout = Layout::from_size_align(size, 1).unwrap();
    let threadsleeptime = 10;
    
    unsafe {
        let ptr = alloc(layout);
        if ptr.is_null() {
            panic!("Allocation failed");
        }

        println!("Allocated {} MB successfully. Waiting for memory fill.", size);
        
        let buffer: &mut [u8] = slice::from_raw_parts_mut(ptr, size);
        buffer.fill(0);
        
        println!("Memory committed. Holding for {} seconds...", threadsleeptime);
        thread::sleep(Duration::from_secs(threadsleeptime));

        println!("Releasing memory now.");
        dealloc(ptr, layout);
    }

    
}
