<script setup>
const emit = defineEmits(["closeModal"]);

function closeModal() {
  emit("closeModal");
}

defineProps({ t: Object });
</script>

<template>
  <div>
    <div class="black-bg">
      <div class="white-bg">
        <h4>{{ t.title }}</h4>
        <p>상세 페이지 내용</p>
        <p>{{ t.title }}</p>
        <p>{{ t.addr1 }}</p>
        <br />
        <button @click="closeModal()">닫기</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
body {
  margin: 0;
}
div {
  box-sizing: border-box;
}
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  left: 0;
  top: 0;
  /* padding: 20px; */
}
.white-bg {
  /* width: 100%; */
  max-width: 300px;
  min-height: 500px;
  position: relative;
  margin: 200px auto;
  padding: 20px;
  border-radius: 8px;
  background: white;
  z-index: 10;
}
</style>
